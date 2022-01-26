package com.example.springproject.services;

import com.example.springproject.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido pedido);
    void sendEmail(SimpleMailMessage simpleMailMessage);
}
