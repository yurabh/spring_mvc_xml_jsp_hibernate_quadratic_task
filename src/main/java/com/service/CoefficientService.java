package com.service;

import com.domain.Coefficient;

public interface CoefficientService {

    void create(Coefficient coefficient);

    Double discriminator(Coefficient coefficient);
}
