package tech.comfortheart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.comfortheart.util.EncryptUtil;

@Controller
public class PasswordEncryptionController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/encrypt")
    @ResponseBody public String encrypt(@RequestBody String plainText) {
        try {
            DatabaseToCsvApp.KeystoreAndCert keyInfo = DatabaseToCsvApp.getKeystoreAndCert();
            return EncryptUtil.encrypt(keyInfo.getCertPath(), plainText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
