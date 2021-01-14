package com.service;

import com.domain.Coefficient;
import com.domain.Root;

public interface RootService {

    Root create(Root root, Coefficient coefficient);

    Root calculateTheRoot(Root root, Coefficient coefficient);
}
