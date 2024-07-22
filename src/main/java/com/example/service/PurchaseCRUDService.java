package com.example.service;

import com.example.Entity.Electronic;
import com.example.Entity.Employee;
import com.example.Entity.Purchase;
import com.example.dto.PurchaseDto;
import com.example.Entity.guide.ElectroType;
import com.example.Entity.guide.PurchaseType;
import com.example.repository.ElectronicRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.PurchaseRepository;
import com.example.repository.PurchaseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PurchaseCRUDService implements CRUDService<PurchaseDto> {

    private final PurchaseRepository purchaseRepository;
    private final EmployeeRepository employeeRepository;
    private final ElectronicRepository electronicRepository;
    private final PurchaseTypeRepository purchaseTypeRepository;

    @Override
    public PurchaseDto getById(Long id) {
        return mapToDto(purchaseRepository.findById(id).orElseThrow());
    }

    @Override
    public Collection<PurchaseDto> getAll() {
        return purchaseRepository.findAll()
                .stream()
                .map(PurchaseCRUDService::mapToDto)
                .sorted(Comparator.comparing(PurchaseDto::getDatePurchases))  //Сортировка по дате
                .toList();

    }

    @Override
    public void create(PurchaseDto item) {
        Electronic electronic = electronicRepository.findById(item.getElectroLd()).orElseThrow();
        int count = electronic.getCount();

        Employee employee = employeeRepository.findById(item.getEmployeeLd()).orElseThrow();
        Set<ElectroType> electroTypes = employee.getElectroTypes();
        boolean eTypeTrue = electroTypes.stream().anyMatch(e -> e.equals(electronic.getElectroType()));


        if (eTypeTrue){
            if(count > 0){
                purchaseRepository.save(mapToEntity(item));
                electronic.setCount(count - 1); //при создании покупки -1 колличество
                electronicRepository.save(electronic);
                System.out.println("покупка созданна");
            }else {
                System.out.println("товара нет на складе");

            }
        }else{
            System.out.println("Данный сотрудник не может создать покупку");
        }
    }

    @Override
    public void update(PurchaseDto item) {
        purchaseRepository.save(mapToEntity(item));
    }

    @Override
    public void delete(Long id) {
        purchaseRepository.deleteById(id);
    }



    public  Purchase mapToEntity(PurchaseDto purchaseDto){
        Purchase purchase = new Purchase();
        Employee employee = employeeRepository.findById(purchaseDto.getEmployeeLd()).orElseThrow();
        Electronic electronic = electronicRepository.findById(purchaseDto.getElectroLd()).orElseThrow();
        PurchaseType purchaseType = purchaseTypeRepository.findById(purchaseDto.getPurchaseType()).orElseThrow();

        purchase.setPurchaseType(purchaseType);
        purchase.setElectronic(electronic);
        purchase.setEmployee(employee);
        purchase.setId(purchaseDto.getId());
        purchase.setDatePurchases(purchaseDto.getDatePurchases());
        return purchase;
    }


    public static PurchaseDto mapToDto(Purchase purchase){
        PurchaseDto purchaseDto = new PurchaseDto();
        PurchaseType purchaseType = purchase.getPurchaseType();
        Electronic electronic = purchase.getElectronic();
        Employee employee = purchase.getEmployee();


        purchaseDto.setId(purchase.getId());
        purchaseDto.setDatePurchases(purchase.getDatePurchases());
        purchaseDto.setPurchaseType(purchaseType.getId());
        purchaseDto.setElectroLd(electronic.getId());
        purchaseDto.setEmployeeLd(employee.getId());

        return purchaseDto;
    }

}
