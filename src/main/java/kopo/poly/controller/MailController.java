package kopo.poly.controller;

import kopo.poly.dto.MailDTO;
import kopo.poly.dto.MsgDTO;
import kopo.poly.service.IMailService;
import kopo.poly.util.CmmUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequestMapping(value = "/mail")
@RequiredArgsConstructor
@Controller
public class MailController {

    private final IMailService mailService; //메일 발송을 위한 서비스 객체 사용

    @GetMapping(value = "mailForm")
    public String mailForm() throws Exception{

        //로그 찍기
        log.info(this.getClass().getName()+"mailForm Start!");

        return "/mail/mailForm";
    }

    @ResponseBody
    @PostMapping(value = "sendMail")
    public MsgDTO sendMail(HttpServletRequest request, ModelMap model) throws Exception {

        //로그 찍기
        log.info(this.getClass().getName() + ".sendMail Start!");

        String msg = ""; //발송 결과 메시지

        //웹 URL로부터 전달받는 값들
        String toMail = CmmUtil.nvl(request.getParameter("toMail")); //받는사람
        String title = CmmUtil.nvl(request.getParameter("title")); //메일제목
        String contents = CmmUtil.nvl(request.getParameter("contents")); //메일내용

        log.info("toMail : " + toMail);
        log.info("title : " + title);
        log.info("contents : " + contents);

        //메일 발송할 정보 넣기 위한 DTO객체 생성하기
        MailDTO pDTO = new MailDTO();

        //웹에서 받은 값을 DTO에 넣기
        pDTO.setToMail(toMail); // 받는 사람을 DTO 저장
        pDTO.setTitle((title)); // 제목 DTO 저장
        pDTO.setContents(contents); // 내용 DTO 저장

        //메일 발송하기
        int res = mailService.doSendMail(pDTO);

        if (res == 1) { //메일 발송 성공
            msg = "메일 발송하였습니다.";
        } else { //메일 발송 실패
            msg = "메일 발송 실패했습니다.";
        }

        log.info(msg);

        //결과 메시지 전달하기
        MsgDTO dto = new MsgDTO();
        dto.setMsg(msg);

        //로그 찍기(추후 찍은 로그를 통해 이 함수 호출이 끝났는지 파악하기 용이하다.
        log.info(this.getClass().getName() + ".sendMail End!");

        return dto;


    }

}
