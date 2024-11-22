package kr.co.FortunaFinance_Server.DTO.accounting;

import lombok.Data;

import java.util.Date;

@Data
public class LedgerListRes {

    private int acindex;
    private int No;
    private String projectidx;
    private String account;
    private String sortation;
    private int accountindex;
    private Date date;
    private int supplyprice;
    private int surtax;
    private int totalamount;
    private int cpindex;
    private String notice;

}
