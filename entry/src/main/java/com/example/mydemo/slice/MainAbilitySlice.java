package com.example.mydemo.slice;

import com.example.mydemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.TabList;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.window.dialog.ToastDialog;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainAbilitySlice extends AbilitySlice {
    private Button button;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        button= (Button) findComponentById(ResourceTable.Id_bt_show);

        if (null!=button){
            ShapeElement shapeElement=new ShapeElement();
            shapeElement.setRgbColor(new RgbColor(0,125,255));
            shapeElement.setCornerRadius(25);
            button.setBackground(shapeElement);
        }
        button.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {

                Intent intent = new Intent();
                Operation operation = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withBundleName("com.example.mydemo")
                        .withAbilityName("com.example.mydemo.MainAbility2")
                        .build();
                intent.setOperation(operation);
                startAbility(intent);

                Logger.getGlobal().log(Level.WARNING,"1111111111111==================>");
            }
        });


        TabList tabList = (TabList) findComponentById(ResourceTable.Id_tab_list);
        for (int i = 0; i < 5; i++) {
            TabList.Tab tab = tabList.new Tab(getContext());
            tab.setText("Image"+i);
            tabList.addTab(tab);
        }
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
