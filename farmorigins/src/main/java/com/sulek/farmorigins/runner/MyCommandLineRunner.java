package com.sulek.farmorigins.runner;

import com.sulek.farmorigins.entity.User;
import com.sulek.farmorigins.entity.parameter.Category;
import com.sulek.farmorigins.entity.parameter.UnitType;
import com.sulek.farmorigins.repository.UserRepository;
import com.sulek.farmorigins.repository.parameter.CategoryRepository;
import com.sulek.farmorigins.repository.parameter.UnitTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class MyCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final UnitTypeRepository unitTypeRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public void run(String... args) throws Exception {
        User user = User.builder()
                .email("bugramertdb@gmail.com")
                .password(bCryptPasswordEncoder.encode("1234"))
                .firstName("buğra")
                .lastName("ayar")
                .phoneNumber("053353533")
                .userRole(1)
                .emailActivision(false)
                .build();
        user.setStatus(true);
        user.setCreatedAt(new Date());
        userRepository.save(user);
        userRepository.flush();
        Category category1 = new Category(1L, "süt ürünleri", "süt ürünleri");
        Category category2 = new Category(2L, "et ürünleri", "et ürünleri");
        Category category3 = new Category(3L, "bitkisel ürünleri", "bitkisel ürünleri");
        List<Category> categoryList = List.of(category1, category2,category3);
        categoryRepository.saveAll(categoryList);
        categoryRepository.flush();
        UnitType unitType1 = new UnitType(1L, "kg", "kilogram");
        UnitType unitType2 = new UnitType(2L, "litre", "litre");
        UnitType unitType3 = new UnitType(3L, "adet", "adet");
        List<UnitType> unitTypeList = List.of(unitType1, unitType2,unitType3);
        unitTypeRepository.saveAll(unitTypeList);
        unitTypeRepository.flush();
    }
}
