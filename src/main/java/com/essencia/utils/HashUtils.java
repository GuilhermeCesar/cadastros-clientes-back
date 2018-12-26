package com.essencia.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

public class HashUtils {

    public static String getFilehashSha1(String fileName){
        String filenameClean = StringUtils.cleanPath(fileName);
        String fileExtension = StringUtils.getFilenameExtension(filenameClean);
        String onlyFileName = StringUtils.stripFilenameExtension(filenameClean);
        String sha1 = DigestUtils.sha1Hex(onlyFileName);

        return sha1.concat(".")
                .concat(fileExtension);

    }
}
