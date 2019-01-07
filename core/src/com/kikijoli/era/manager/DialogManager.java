/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.era.manager;

import de.tomgrill.gdxdialogs.core.GDXDialogs;
import de.tomgrill.gdxdialogs.core.GDXDialogsSystem;
import de.tomgrill.gdxdialogs.core.dialogs.GDXButtonDialog;
import de.tomgrill.gdxdialogs.core.dialogs.GDXTextPrompt;
import de.tomgrill.gdxdialogs.core.listener.ButtonClickListener;
import de.tomgrill.gdxdialogs.core.listener.TextPromptListener;

/**
 *
 * @author Administrateur
 */
public class DialogManager {

    public static GDXDialogs dialogs;

    static {
        dialogs = GDXDialogsSystem.install();
    }

    public static void showButtonDialog(ButtonClickListener listener) {
        GDXButtonDialog bDialog = dialogs.newDialog(GDXButtonDialog.class);
        bDialog.setTitle("Buy a item");
        bDialog.setMessage("Do you want to buy the mozarella?");

        bDialog.setClickListener(listener);

        bDialog.addButton("No");
        bDialog.addButton("Never");
        bDialog.addButton("Yes, nomnom!");

        bDialog.build().show();
    }

    public static void showPromptDialog(String title, String message, String ok, String cancel, TextPromptListener listener) {
        GDXTextPrompt textPrompt = dialogs.newDialog(GDXTextPrompt.class);
        textPrompt.setTitle(title);
        textPrompt.setMessage(message);
        textPrompt.setCancelButtonLabel(cancel);
        textPrompt.setConfirmButtonLabel(ok);
        textPrompt.setTextPromptListener(listener);

        textPrompt.build().show();
    }
}
