package com.test.test.services;

import java.security.InvalidParameterException;

public class Factory {

    public abstract class LocalActivity {
        public abstract String getActivity();
    }

    public class Monday extends LocalActivity {
        @Override
        public String getActivity() {
            return "Fishing";
        }
    }

    public class Tuesday extends LocalActivity {
        @Override
        public String getActivity() {
            return "Climbing";
        }
    }

    public class Wednesday extends LocalActivity {
        @Override
        public String getActivity() {
            return "Swimming";
        }
    }

    public class Friday extends LocalActivity {
        @Override
        public String getActivity() {
            return "Fishing";
        }
    }

    public class Saturday extends LocalActivity {
        @Override
        public String getActivity() {
            return "Sky Diving";
        }
    }

    public class Sunday extends LocalActivity {
        @Override
        public String getActivity() {
            return "Sky Diving";
        }
    }
    public LocalActivity getActivity(String date) {
        switch (date) {
            case "Monday":
                return new Monday();
            case "Tuesday":
                return new Tuesday();
            case "Wednesday":
                return new Wednesday();
            case "Friday":
                return new Friday();
            case "Saturday":
                return new Saturday();
            case "Sunday":
                return new Sunday();
            default:
                break;
        }
        throw new InvalidParameterException("Date " + date + " Not Found");
    }
}
