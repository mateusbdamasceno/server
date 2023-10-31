package com.project.server;

import com.project.services.Mp3Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class Mp3UtilTest {

    @Test
    void getArtist_shouldBe_KraftClub() {
        String artist = Mp3Util.getArtist(Paths.get("./my.mp3"));
        Assertions.assertEquals("Artista: ", artist);
    }
}
