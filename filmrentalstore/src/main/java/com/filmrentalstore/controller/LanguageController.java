package com.filmrentalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrentalstore.model.Language;
import com.filmrentalstore.model.LanguageEnum;
import com.filmrentalstore.repository.LanguageRepo;

@RestController
@RequestMapping("api/languages")
public class LanguageController {
	@Autowired
	private LanguageRepo languageRepo;
	
	@PostMapping("/insertAll")
    public ResponseEntity<String> insertAllLanguages() {
        try {
            // Iterate through all LanguageEnum values and save them to the database
            for (LanguageEnum languageEnum : LanguageEnum.values()) {
                Language language = new Language();
                language.setName(languageEnum);
                languageRepo.save(language);
            }

            return ResponseEntity.ok("All languages inserted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error inserting languages: " + e.getMessage());
        }
    }
	
	@PostMapping("/insert")
    public ResponseEntity<String> insertLanguage(@RequestBody String languageName) {
        try {
            LanguageEnum languageEnum = LanguageEnum.valueOf(languageName.toUpperCase());
            Language language = new Language();
            language.setName(languageEnum);
            languageRepo.save(language);

            return ResponseEntity.ok("Language inserted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid language name provided.");
        }
    }
	
	@GetMapping("/all")
    public ResponseEntity<List<Language>> getAllLanguages() {
        List<Language> languages = languageRepo.findAll();
        return ResponseEntity.ok(languages);
    }
}
