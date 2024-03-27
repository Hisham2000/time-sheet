package com.example.Back.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailData {
    private String recipientTo;
    private String recipientCC;
    private String recipientBCC;
    private String subject;
    private String fileName;
    private byte[] attachments;

}
