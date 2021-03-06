/*
 * Copyright (C) 2016 - present Instructure, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.instructure.canvasapi.model;

import android.os.Parcel;

import java.util.Date;

public class NotificationPreference extends CanvasModel<NotificationPreference> {

    public String notification;
    public String category;
    public String frequency;

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getComparisonString() {
        return null;
    }

    @Override
    public Date getComparisonDate() {
        return null;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.notification);
        dest.writeString(this.category);
        dest.writeString(this.frequency);
    }

    public NotificationPreference() {
    }

    private NotificationPreference(Parcel in) {
        this.notification = in.readString();
        this.category = in.readString();
        this.frequency = in.readString();
    }

    public static final Creator<NotificationPreference> CREATOR = new Creator<NotificationPreference>() {
        public NotificationPreference createFromParcel(Parcel source) {
            return new NotificationPreference(source);
        }

        public NotificationPreference[] newArray(int size) {
            return new NotificationPreference[size];
        }
    };
}
