package kopo.poly.service;

import kopo.poly.dto.MailDTO;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


public interface IMailService {

    //메일 발송
    int doSendMail(MailDTO pDTO);
}
