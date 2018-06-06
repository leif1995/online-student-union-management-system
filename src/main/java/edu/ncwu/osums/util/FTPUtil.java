package edu.ncwu.osums.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

public class FTPUtil {
    public static void uploadFile(MultipartFile multipartFile, String fileName, String fTPPath) {
        FTPClient fTPClient = new FTPClient();
        InputStream inputStream = null;

        try {
            fTPClient.connect("127.0.0.1", 21);
            fTPClient.login("Administrator", "lbc19951022");
            boolean hasDirectory = fTPClient.changeWorkingDirectory(fTPPath);

            if (!hasDirectory) {
                fTPClient.makeDirectory(fTPPath);
            }

            fTPClient.changeWorkingDirectory(fTPPath);
            fTPClient.setFileType(FTP.BINARY_FILE_TYPE);
            inputStream = multipartFile.getInputStream();
            fTPClient.storeFile(fileName, inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                fTPClient.logout();
                fTPClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteFile(String fileName, String fTPPath) {
        FTPClient fTPClient = new FTPClient();

        try {
            fTPClient.connect("127.0.0.1", 21);
            fTPClient.login("Administrator", "lbc19951022");
            fTPClient.changeWorkingDirectory(fTPPath);
            fTPClient.deleteFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fTPClient.logout();
                fTPClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
