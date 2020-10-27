package com.example.bakery.web;

import com.example.bakery.domain.Bread;
import com.example.bakery.domain.BreadRepository;
import com.example.bakery.domain.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
public class BakeryController {
    @Autowired
    private BreadRepository breadRepository;

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping(value = "/breadlist")
    public String breadList(Model model){
        model.addAttribute("breads", breadRepository.findAll());
        return "breadlist";
    }

    @GetMapping(value = "/add")
    public String addBread(Model model){
        model.addAttribute("bread", new Bread());
        //Inject type repository to controller
        model.addAttribute("types", typeRepository.findAll());
        return "addbread";
    }

    @PostMapping(value = "/save")
    public String save(Bread  bread){
        breadRepository.save(bread);
        return "redirect:breadlist";
    }

    //Delete function
    @GetMapping(value = "/delete/{id}")
    public String deleteBread(@PathVariable("id") Long breadId, Model model){
        breadRepository.deleteById(breadId);
        return "redirect:../breadlist";
    }

    //Edit bread
    @GetMapping(value = "/edit/{id}")
    public String editBread(@PathVariable("id") Long id, Model model){
        model.addAttribute("bread", breadRepository.findById(id));
        model.addAttribute("types", typeRepository.findAll());
        return "editbread";
    }
}
