package service;

import domain.Coefficient;
import domain.Root;

public interface RootService {

    Root create(Root root, Coefficient coefficient);

    Root calculateTheRoot(Root root, Coefficient coefficient);
}
