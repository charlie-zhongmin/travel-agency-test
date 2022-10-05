package com.test.test.services;

import java.util.Objects;

public class Factory {

    interface LocalActivity {
        public String getActivity();
    }

    static class Monday implements LocalActivity {
        @Override
        public String getActivity() {
            return "Fishing";
        }
    }

    static class Tuesday implements LocalActivity {
        @Override
        public String getActivity() {
            return "Climbing";
        }
    }

    static class Wednesday implements LocalActivity {
        @Override
        public String getActivity() {
            return "Swimming";
        }
    }

    static class Friday implements LocalActivity {
        @Override
        public String getActivity() {
            return "Fishing";
        }
    }

    static class Saturday implements LocalActivity {
        @Override
        public String getActivity() {
            return "Sky Diving";
        }
    }

    static class Sunday implements LocalActivity {
        @Override
        public String getActivity() {
            return "Sky Diving";
        }
    }

    static class ActivityFactory {
        public static LocalActivity getActivity(String date) {
//            switch (date) {
//                case "Monday":
//                    return new Monday();
//                case "Tuesday":
//                    return new Tuesday();
//                case "Wednesday":
//                    return new Wednesday();
//                case "Friday":
//                    return new Friday();
//                case "Saturday":
//                    return new Saturday();
//                case "Sunday":
//                    return new Sunday();
//                default:
//                    return null;
//            }
            if (Objects.equals("Monday", date)) {
                return new Monday();
            } else if (Objects.equals("Tuesday", date)) {
                return new Tuesday();
            } else if (Objects.equals("Wednesday", date)) {
                return new Wednesday();
            } else if (Objects.equals("Friday", date)) {
                return new Friday();
            } else if (Objects.equals("Saturday", date)) {
                return new Saturday();
            } else if (Objects.equals("Sunday", date)) {
                return new Sunday();
            } else {
                return null;
            }
        }
    }
}
