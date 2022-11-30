package io.github.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class LangRepository {
    private List<Lang> languages;

    LangRepository() {
        languages = new ArrayList<>();
        languages.add(new Lang(1L,"Hello", "EN"));
        languages.add(new Lang(2L,"Witaj", "PL"));
    }

    Optional<Lang> findByID(Long id) {
        return languages.stream()
                        .filter(lang -> lang.getId().equals(id))
                        .findFirst();
    }
}
