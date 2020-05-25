package com.uca.capas.controller;

import com.sun.xml.bind.v2.schemagen.xmlschema.Import;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ContribuyenteService contribuyenteService;
    @Autowired
    private ImportanciaService importanciaService;

    @RequestMapping("/contribuyente")
    public ModelAndView initMain(@ModelAttribute Contribuyente contribuyente) {
        ModelAndView mav = new ModelAndView();
        List<Importancia> importanciaList = null;

        try {
            importanciaList = importanciaService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("contribuyente", contribuyente);
        mav.addObject("importanciaList", importanciaList);
        mav.setViewName("inicio");
        return mav;
    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult br) throws ParseException {
        ModelAndView mav = new ModelAndView();
        List<Importancia> importanciaList = importanciaService.findAll();

        if (br.hasErrors()) {
            mav.addObject("importanciaList", importanciaList);
            mav.setViewName("inicio");
            System.out.println("error");
        } else {
            try {
                contribuyente.setfIngreso(new Date());
                contribuyenteService.save(contribuyente);
                System.out.println("guardado");
                mav.setViewName("exito");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mav;
    }

    @RequestMapping("/verContribuyente")
    public ModelAndView mostrarContribuyentes() {
        ModelAndView mav = new ModelAndView();
        List<Contribuyente> contribuyentes = contribuyenteService.findAll();
        mav.addObject("contribuyentes", contribuyentes);
        mav.setViewName("listaContribuyentes");
        return mav;
    }
}
