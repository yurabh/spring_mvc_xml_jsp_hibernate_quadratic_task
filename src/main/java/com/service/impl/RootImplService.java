package com.service.impl;

import com.dao.RootDao;
import com.domain.Coefficient;
import com.domain.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.CoefficientService;
import com.service.RootService;

@Service
public class RootImplService implements RootService {

    private RootDao rootDao;

    private CoefficientService coefficientService;

    @Autowired
    public RootImplService(RootDao rootDao, CoefficientService coefficientService) {
        this.rootDao = rootDao;
        this.coefficientService = coefficientService;
    }

    @Override
    public Root create(Root root, Coefficient coefficient) {
        Root rootNew = calculateTheRoot(root, coefficient);
        if (rootNew != null) {
            rootDao.create(rootNew);
        }
        return rootNew;
    }

    @Override
    public Root calculateTheRoot(Root root, Coefficient coefficient) {
        Double d = coefficientService.discriminator(coefficient);

        if (d == 0) {
            Double x = coefficient.getB() * (-1) / (2 * coefficient.getA());
            root.setX1(x);
            root.setX2(0.0);
            return root;
        }
        if (d > 0) {
            Double x1 = (coefficient.getB() * (-1) + Math.sqrt(d)) / (2 * coefficient.getA());
            Double x2 = (coefficient.getB() * (-1) - Math.sqrt(d)) / (2 * coefficient.getA());
            root.setX1(x1);
            root.setX2(x2);
            return root;
        } else {
            return null;
        }
    }
}
