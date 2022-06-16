package com.company.dto;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;


@Getter
@Setter
public class ValuyutaKurslari {

    private LocalDate localDate = LocalDate.now();

    private RateDTO usb = getDolar("USD", localDate.toString());

    private RateDTO cny = getDolar("CNY", localDate.toString());

    private RateDTO eur = getDolar("EUR", localDate.toString());

    private RateDTO gbp = getDolar("GBP", localDate.toString());

    private RateDTO rub = getDolar("RUB", localDate.toString());

    private RateDTO jpy = getDolar("JPY", localDate.toString());

    private RateDTO chf = getDolar("CHF", localDate.toString());

    private RateDTO kzt = getDolar("KZT", localDate.toString());

    private RateDTO sgd = getDolar("SGD", localDate.toString());

    private RateDTO brl = getDolar("BRL", localDate.toString());

/*

    public RateDTO getUsb() {
        return usb;
    }


    public RateDTO getCny() {
        return cny;
    }


    public RateDTO getEur() {
        return eur;
    }


    public RateDTO getGbp() {
        return gbp;
    }


    public RateDTO getRub() {
        return rub;
    }


    public RateDTO getJpy() {
        return jpy;
    }


    public RateDTO getChf() {
        return chf;
    }


    public RateDTO getKzt() {
        return kzt;
    }


    public RateDTO getSgd() {
        return sgd;
    }

    public RateDTO getBrl() {
        return brl;
    }
*/


    public String print(RateDTO rateDTO) {
        return ("🏦   " + "Markaziy  bankning  yangilangan  vaqti   " + "\uD83D\uDD5B    " + rateDTO.getDate() + "  \nBugun  1 " + rateDTO.getCcyNm_UZ() + "   " + rateDTO.getRate()) + "  sumni tashkil etmoqda";
    }


    public Double convertor(RateDTO rateDTO, Double money) {
        return money / rateDTO.getRate();
    }


    public Double convertorSUM(RateDTO rateDTO, Double money) {
        return rateDTO.getRate() * money;
    }


    public RateDTO getDolar(String kurs, String date) {
        StringBuilder str = getBank(kurs, date);

        Gson gson = new Gson();
        RateDTO[] rate = gson.fromJson(str.toString(), RateDTO[].class);
        return rate[0];
    }


    public StringBuilder getBank(String kurs, String date) {
        StringBuilder str = new StringBuilder();
        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/" + kurs + "/" + date + "/");
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

            String line = bufferedReader.readLine();
            while (line != null) {
                str.append(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}