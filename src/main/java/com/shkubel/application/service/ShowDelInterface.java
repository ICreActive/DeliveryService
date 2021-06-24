package com.shkubel.application.service;

import java.io.FileNotFoundException;

public interface ShowDelInterface {

    void show() throws FileNotFoundException;

    void delete(long id);

}
