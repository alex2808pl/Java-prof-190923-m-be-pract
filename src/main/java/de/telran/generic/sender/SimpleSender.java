package de.telran.generic.sender;

public class SimpleSender {
    public static void main(String[] args) {
        PrepareData prepData = new PrepareData();
        String data = prepData.prepareData(Viber.class);
        SendMessage message = new Viber();
        String report = message.generateReport(data);
        boolean isSend = message.sendReport(report);
        System.out.println("isSend = "+isSend);
        System.out.println();

        data = prepData.prepareData(Telegram.class);
        message = new Telegram();
        report = message.generateReport(data);
        isSend = message.sendReport(report);
        System.out.println("isSend = "+isSend);
        System.out.println();

        data = prepData.prepareData(WhatsApp.class);
        message = new WhatsApp();
        report = message.generateReport(data);
        isSend = message.sendReport(report);
        System.out.println("isSend = "+isSend);
        System.out.println();

        data = prepData.prepareData(EMail.class);
        message = new EMail();
        report = message.generateReport(data);
        isSend = message.sendReport(report);
        System.out.println("isSend = "+isSend);
        System.out.println();

        // Изыскания

        ReportText reportText = new Viber(); // можно

        ReportText reportText1 = new ReportText() {
            @Override
            public boolean sendReport(String report) {
                throw new UnsupportedOperationException();
            }
        };

     // Test testInterface = new Test(); // нельзя создать обїект интерфейса, даже если у него все методы имеют default

        testPolymorph(new Viber());

    }
    static void testPolymorph(SendMessage sm) {
        sm.sendReport("testReport");
        sm.generateReport("testData");
    }
}


