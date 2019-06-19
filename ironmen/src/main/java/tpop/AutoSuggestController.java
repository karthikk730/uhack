package tpop;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class AutoSuggestController {

    @Autowired
    private AutoSuggestService autoSuggestService;

   @RequestMapping("/hack/autoSuggest/{prefixString}")
    public List getAutoCompleteSuggestions(@PathVariable("prefixString") String prefixString) {

        return autoSuggestService.getSuggestion(prefixString);
    }
}
