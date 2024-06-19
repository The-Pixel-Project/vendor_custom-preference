/*
 * Copyright (C) 2022 Project Kaleidoscope
 * Copyright (C) 2024 TheParasiteProject
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.custom.preference;

import android.provider.DeviceConfig;
import android.preference.PreferenceDataStore;

public class DeviceConfigStore extends androidx.preference.PreferenceDataStore
        implements PreferenceDataStore {

    public DeviceConfigStore() {
    }

    public boolean getBoolean(String key, boolean defValue) {
        return DeviceConfig.getBoolean(getNameSpace(key), getKey(key), defValue);
    }

    public int getInt(String key, int defValue) {
        return DeviceConfig.getInt(getNameSpace(key), getKey(key), defValue);
    }

    public long getLong(String key, long defValue) {
        return DeviceConfig.getLong(getNameSpace(key), getKey(key), defValue);
    }

    public String getString(String key, String defValue) {
        return DeviceConfig.getString(getNameSpace(key), getKey(key), defValue);
    }

    public void putBoolean(String key, boolean value) {
        DeviceConfig.setProperty(getNameSpace(key), getKey(key), Boolean.toString(value), false);
    }

    public void putInt(String key, int value) {
        DeviceConfig.setProperty(getNameSpace(key), getKey(key), Integer.toString(value), false);
    }

    public void putLong(String key, long value) {
        DeviceConfig.setProperty(getNameSpace(key), getKey(key), Long.toString(value), false);
    }

    public void putString(String key, String value) {
        DeviceConfig.setProperty(getNameSpace(key), getKey(key), value, false);
    }

    private String getNameSpace(String fullKey) {
        String[] nsKey = fullKey.split("/");
        return nsKey[0];
    }

    private String getKey(String fullKey) {
        String[] nsKey = fullKey.split("/");
        return nsKey[1];
    }

}
