package com.service.impl;

import com.dao.CoefficientDao;
import com.domain.Coefficient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.CoefficientService;

@Service
public class CoefficientImplService implements CoefficientService {

    private CoefficientDao coefficientDao;

    @Autowired
    public CoefficientImplService(CoefficientDao coefficientDao) {
        this.coefficientDao = coefficientDao;
    }

    @Override
    public void create(Coefficient coefficient) {
        coefficientDao.create(coefficient);
    }

    @Override
    public Double discriminator(Coefficient coefficient) {
        return (coefficient.getB() * coefficient.getB()) - (4 * coefficient.getA() * coefficient.getC());
    }
}
