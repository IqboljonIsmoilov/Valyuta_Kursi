package com.company.service;

import com.company.controller.ControllerCompanet;
import com.company.repository.ValyutaKursi;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.LinkedList;
import java.util.List;

public class TelegramBOT extends TelegramLongPollingBot {
    private String toMessage = "";


    @Override
    public String getBotUsername() {
        return "@Valyuta_kurs2022_bot";
    }


    @Override
    public String getBotToken() {
        return "5239991194:AAF_3zZ5flEmg204RO1HAYBXkyY5UhC_lgc";
    }


    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        User user = null;
        Message message = null;
        if (update.hasCallbackQuery()) {
            getCollbackQuery(update);

        } else {
            message = update.getMessage();
            String text = message.getText();
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            if (text.equals("/start")) {
                getSendMessage(message);
            } else if (toMessage.equals("som")) {
                toMessage = "";
                Double money = ValyutaKursi.valuyutaKurslari.convertor(ControllerCompanet.BankKurs, Double.valueOf(text));
                sendMessage.setText(text + "  so`m " + "  ➖➖➖   " + String.valueOf(money)+"   ga teng");
                sendMessagePrint(sendMessage);
            } else if (toMessage.equals("valyuta")) {
                toMessage = "";
                Double money = ValyutaKursi.valuyutaKurslari.convertorSUM(ControllerCompanet.BankKurs, Double.valueOf(text));
                sendMessage.setText(text + "  ➖➖➖   " + String.valueOf(money) + "  so`m ga teng");
                sendMessagePrint(sendMessage);
            } else {
                sendMessage.setText("Bunaqa malumot yoq");
                sendMessagePrint(sendMessage);
            }
        }
    }


    public void sendMessagePrint(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void editMessagePrint(EditMessageText editMessageText) {
        try {
            execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void getCollbackQuery(Update update) {

        User user = null;
        Message message = null;
        CallbackQuery callbackQuery = update.getCallbackQuery();
        String date = callbackQuery.getData();
        user = callbackQuery.getFrom();
        message = callbackQuery.getMessage();
        SendMessage sendMessage =  new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        if (date.equals("usd")) {
            getNewSedMessage(message, ValyutaKursi.valuyutaKurslari.print(ValyutaKursi.valuyutaKurslari.getUsb()));
            ControllerCompanet.BankKurs = ValyutaKursi.valuyutaKurslari.getUsb();
        } else if (date.equals("cny")) {
            getNewSedMessage(message, ValyutaKursi.valuyutaKurslari.print(ValyutaKursi.valuyutaKurslari.getCny()));
            ControllerCompanet.BankKurs = ValyutaKursi.valuyutaKurslari.getCny();
        } else if (date.equals("eur")) {
            getNewSedMessage(message, ValyutaKursi.valuyutaKurslari.print(ValyutaKursi.valuyutaKurslari.getEur()));
            ControllerCompanet.BankKurs = ValyutaKursi.valuyutaKurslari.getEur();
        }else if (date.equals("gbp")) {
            getNewSedMessage(message, ValyutaKursi.valuyutaKurslari.print(ValyutaKursi.valuyutaKurslari.getGbp()));
            ControllerCompanet.BankKurs = ValyutaKursi.valuyutaKurslari.getGbp();
        }else if (date.equals("rub")) {
            getNewSedMessage(message, ValyutaKursi.valuyutaKurslari.print(ValyutaKursi.valuyutaKurslari.getRub()));
            ControllerCompanet.BankKurs = ValyutaKursi.valuyutaKurslari.getRub();
        }else if (date.equals("jpy")) {
            getNewSedMessage(message, ValyutaKursi.valuyutaKurslari.print(ValyutaKursi.valuyutaKurslari.getJpy()));
            ControllerCompanet.BankKurs = ValyutaKursi.valuyutaKurslari.getJpy();
        }else if (date.equals("chf")) {
            getNewSedMessage(message, ValyutaKursi.valuyutaKurslari.print(ValyutaKursi.valuyutaKurslari.getChf()));
            ControllerCompanet.BankKurs = ValyutaKursi.valuyutaKurslari.getChf();
        }else if (date.equals("kzt")) {
            getNewSedMessage(message, ValyutaKursi.valuyutaKurslari.print(ValyutaKursi.valuyutaKurslari.getKzt()));
            ControllerCompanet.BankKurs = ValyutaKursi.valuyutaKurslari.getKzt();
        }else if (date.equals("sgd")) {
            getNewSedMessage(message, ValyutaKursi.valuyutaKurslari.print(ValyutaKursi.valuyutaKurslari.getSgd()));
            ControllerCompanet.BankKurs = ValyutaKursi.valuyutaKurslari.getSgd();
        }else if (date.equals("brl")) {
            getNewSedMessage(message, ValyutaKursi.valuyutaKurslari.print(ValyutaKursi.valuyutaKurslari.getBrl()));
            ControllerCompanet.BankKurs = ValyutaKursi.valuyutaKurslari.getBrl();
        }else if (date.equals("nazat")) {
            getSendMessage(message);
        } else if (date.equals("som")) {
            sendMessage.setText("✒️️ " + " So`mni qiymatini kiriting");
            toMessage = "som";
            sendMessagePrint(sendMessage);
        } else if (date.equals("valyuta")) {
            sendMessage.setText("✒️️ " + " Valyutani qiymatini kiriting");
            toMessage = "valyuta";
            sendMessagePrint(sendMessage);
        }
    }


    public void getNewSedMessage(Message message, String infor) {
        EditMessageText editMessageText = new EditMessageText();

        editMessageText.setText(infor);
        editMessageText.setParseMode("Markdown");
        editMessageText.setChatId(String.valueOf(message.getChatId()));
        editMessageText.setMessageId(message.getMessageId());

        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("\uD83D\uDCB6  " + "So`mni valyutaga");
        button.setCallbackData("som");
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("\uD83D\uDCB7  " + "Valyutani so`mga");
        button1.setCallbackData("valyuta");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("🔙   " + "Orqaga");
        button2.setCallbackData("nazat");

        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(button1);
        row.add(button);
        List<InlineKeyboardButton> row1 = new LinkedList<>();
        row1.add(button2);

        List<List<InlineKeyboardButton>> rowCollection = new LinkedList<>();
        rowCollection.add(row);
        rowCollection.add(row1);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowCollection);

        editMessageText.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void getSendMessage(Message message) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        sendMessage.setText("Assalomu Alaykum qaysi " + " \uD83D\uDCB8 " + " valyuta kursini bilmoqchisiz?");
        sendMessage.setParseMode("Markdown");

        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("\uD83D\uDCB5  " + "USD Dollor");
        button.setCallbackData("usd");

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("\uD83D\uDCB4  " + "CNY Yuan");
        button1.setCallbackData("cny");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("\uD83D\uDCB6  " + "EUR Euro");
        button2.setCallbackData("eur");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("\uD83D\uDCB7  " + "GBP Funt");
        button3.setCallbackData("gbp");

        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText("\uD83D\uDCB5  " + "RUB Rubl");
        button4.setCallbackData("rub");

        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText("\uD83D\uDCB4  " + "JPY Iyena");
        button5.setCallbackData("jpy");

        InlineKeyboardButton button6 = new InlineKeyboardButton();
        button6.setText("\uD83D\uDCB6  " + "CHF Frank");
        button6.setCallbackData("chf");

        InlineKeyboardButton button7 = new InlineKeyboardButton();
        button7.setText("\uD83D\uDCB7  " + "KZT Tenge");
        button7.setCallbackData("kzt");

        InlineKeyboardButton button8 = new InlineKeyboardButton();
        button8.setText("\uD83D\uDCB5  " + "SGD Dollor");
        button8.setCallbackData("sgd");

        InlineKeyboardButton button9 = new InlineKeyboardButton();
        button9.setText("\uD83D\uDCB6  " + "BRL Real");
        button9.setCallbackData("brl");

        List<InlineKeyboardButton> row = new LinkedList<>();
        row.add(button);

        List<InlineKeyboardButton> row1 = new LinkedList<>();
        row1.add(button2);
        row1.add(button9);

        List<InlineKeyboardButton> row2 = new LinkedList<>();
        row2.add(button1);
        row2.add(button3);

        List<InlineKeyboardButton> row3 = new LinkedList<>();
        row3.add(button5);
        row3.add(button6);

        List<InlineKeyboardButton> row4 = new LinkedList<>();
        row4.add(button7);
        row4.add(button8);

        List<InlineKeyboardButton> row5 = new LinkedList<>();
        row5.add(button4);

        List<List<InlineKeyboardButton>> rowCollection = new LinkedList<>();
        rowCollection.add(row);
        rowCollection.add(row1);
        rowCollection.add(row2);
        rowCollection.add(row3);
        rowCollection.add(row4);
        rowCollection.add(row5);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowCollection);

        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        sendMessagePrint(sendMessage);
    }
}
