package org.javaee7.javamail;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.activation.MimetypesFileTypeMap;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Masudul Haque
 */
public class EmailWithCalendar {
    public static void main(String[] args) {
        InviteDTO idto=new InviteDTO();
        final String username = "glowpoint.test@gmail.com";
        final String password = "glow12345";
        String mailTo[] = {Constants.MAIL_TO};
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimetypesFileTypeMap mimetypes = (MimetypesFileTypeMap) MimetypesFileTypeMap.getDefaultFileTypeMap();
            mimetypes.addMimeTypes("text/calendar ics ICS");

            MailcapCommandMap mailcapCommandMap = (MailcapCommandMap) MailcapCommandMap.getDefaultCommandMap();
            mailcapCommandMap.addMailcap("text/calendar;; x-java-content-handler=com.sun.mail.handlers.text_plain");

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("invite@glowpoint.com"));
            InternetAddress[] addressTo = new InternetAddress[mailTo.length];
            for (int i = 0; i < mailTo.length; i++) {
                addressTo[i] = new InternetAddress(mailTo[i].trim());
            }
            msg.setRecipients(Message.RecipientType.TO, addressTo);
            msg.setSubject("Test");
            msg.setSentDate(new Date());

            Multipart multipart = new MimeMultipart("alternative");

            //MimeBodyPart messagePart = new MimeBodyPart();
            //messagePart.setText("Test");
            BodyPart bodyPart = buildHtmlTextPart();
            multipart.addBodyPart(bodyPart);
           // System.out.println("File Name :"+ idto.getFilename());
            if(idto.getFilename()!=null && !idto.getFilename().equals("")){
            BodyPart attachmentPart = buildAttachmentPart(idto);
            multipart.addBodyPart(attachmentPart);
            }
            BodyPart calendarPart = buildCalendarPart(idto);
            multipart.addBodyPart(calendarPart);
            msg.setContent(multipart);
            Transport.send(msg);
        } catch (Exception ex) {
            Logger.getLogger(SendMailTLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static BodyPart buildHtmlTextPart() throws MessagingException {
            MimeBodyPart bodyPart = new MimeBodyPart();

        String content = "<br /><br />You've been invited to join a meeting<br />"+ 
                          "To join the meeting, please click below:<br /><br />"+ 
                          "http://ovr.ovcloud.com/RemoteAuth?room=<br /><br />"+ 
                          "If your email service has disabled the link, please copy the above URL and paste it into your web browser's address bar.";

        bodyPart.setContent(content, "text/html; charset=utf-8");

        return bodyPart;
    }
    
    public static BodyPart buildAttachmentPart(InviteDTO idto) throws MessagingException {

        MimeBodyPart bodyPart = new MimeBodyPart();
        String fileLocation = "src/main/resources/data.txt";
        DataSource source = new FileDataSource(fileLocation);
        bodyPart.setDataHandler(new DataHandler(source));
        bodyPart.setFileName(idto.getFilename());

        return bodyPart;
    }
    //define somewhere the icalendar date format
    //SimpleDateFormat calFormat = new SimpleDateFormat("EEE, MMM d, yyyyhmma");
    private static SimpleDateFormat iCalendarDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmm'00'");

    public static BodyPart buildCalendarPart(InviteDTO idto) throws Exception {

        BodyPart calendarPart = new MimeBodyPart();

        // String praction= idto.getTimeZone().substring(0, idto.getTimeZone().indexOf(","));
        String timeZone = my_time_in(idto.getTimeZone(), "z");
        String rRule = "FREQ=YEARLY;BYMONTH=1;UNTIL=20071231T180000Z";
        String customRule = "";

        if (idto.isIsRecurrance()) {
            String freq = idto.getRepeatType();
            String intervalStr = "";
            String byDay = "";
            String last = "WKST=SU";
            if ("DAILY".equals(freq)) {
                if ("False".equals(idto.getDayType())) {
                    intervalStr = "INTERVAL=" + idto.getDaysRepeat() + ";";
                }
            } else if ("WEEKLY".equals(freq)) {
                if (idto.getWeeklyRepeat() != null) {
                    intervalStr = "INTERVAL=" + idto.getWeeklyRepeat() + ";";
                }
                if (idto.getWeekDays() != null && idto.getWeekDays().length > 0) {
                    byDay = "BYDAY=";
                    for (int i = 0; i < idto.getWeekDays().length; i++) {
                        byDay += idto.getWeekDays()[i];
                        if (i < idto.getWeekDays().length - 1) {
                            byDay += ",";
                        } else {
                            byDay += ";";
                        }
                    }
                }
            } else if ("MONTHLY".equals(freq)) {
                if (idto.getMonthlyRepeat() != null) {
                    intervalStr = "INTERVAL=" + idto.getMonthlyRepeat() + ";";
                }
                if (!"0".equals(idto.getMonthOnWeekDay())) {
                    byDay = "BYDAY=" + idto.getMonthOnWeekDay() + idto.getMonthOnWeekDayType();
                }
            }

            String ending = "";
            String endType = idto.getEndType();
            if ("OCCURRENCES".equals(endType) && idto.getEndOcur() != null) {
                ending = "COUNT=" + idto.getEndOcur() + ";";
            } else if ("ON".equals(endType) && idto.getEndOnDate() != null) {
                ending = "UNTIL=" + iCalendarDateFormat.format(idto.getEndOnDate()) + ";";
            }
            customRule = "RRULE:FREQ=" + freq + ";" + ending + intervalStr + byDay + last + "\n";
        }


        String fromTime = my_time_in(idto.getTimeZone(), "Z");
        //  String toTime="+0700";
        //check the icalendar spec in order to build a more complicated meeting request
        StringBuilder icalText = new StringBuilder();
        icalText.append("BEGIN:VCALENDAR\n")
                .append("VERSION:2.0\n")
                .append("METHOD:REQUEST\n")
                .append("PRODID:-//PYVOBJECT//NONSGML Version 1//EN\n")
                .append("BEGIN:VTIMEZONE\n")
                .append("TZID:").append(timeZone).append("\n")
                .append("BEGIN:STANDARD\n")
                .append("DTSTART:").append(iCalendarDateFormat.format(idto.getFrom())).append("\n")
                .append("RRULE:").append(rRule).append("\n")
                .append("TZNAME:").append(timeZone).append("\n")
                .append("TZOFFSETFROM:").append(fromTime).append("\n")
                .append("TZOFFSETTO:").append(fromTime).append("\n")
                .append("END:STANDARD\n")
                .append("BEGIN:STANDARD\n")
                .append("DTSTART:").append(iCalendarDateFormat.format(idto.getFrom())).append("\n")
                .append("RRULE:").append(rRule).append("\n")
                .append("TZNAME:").append(timeZone).append("\n")
                .append("TZOFFSETFROM:").append(fromTime).append("\n")
                .append("TZOFFSETTO:").append(fromTime).append("\n")
                .append("END:STANDARD\n")
                /*.append("BEGIN:DAYLIGHT\n")
                 .append("DTSTART:20090619T230000\n")
                 .append("RRULE:FREQ=YEARLY;BYDAY=3FR;BYMONTH=6;UNTIL=20090619T170000Z\n")
                 .append("TZNAME:").append(timeZone).append("\n")
                 .append("TZOFFSETFROM:").append(fromTime).append("\n")
                 .append("TZOFFSETTO:").append(toTime).append("\n")
                 .append("END:DAYLIGHT\n")*/
                .append("END:VTIMEZONE\n")
                .append("BEGIN:VEVENT\n")
                .append("UID:").append(System.currentTimeMillis()).append("\n")
                .append("DTSTART;TZID=").append(timeZone).append(":").append(iCalendarDateFormat.format(idto.getFrom())).append("\n")
                .append("DTEND;TZID=").append(timeZone).append(":").append(iCalendarDateFormat.format(idto.getTo())).append("\n")
                .append("ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;RSVP=TRUE:mailto:").append(idto.getMailTo()[0]).append("\n")
                .append("DESCRIPTION:").append(idto.getMailText()).append("\n")
                .append("DTSTAMP:").append(iCalendarDateFormat.format(idto.getFrom())).append("\n")
                .append("LAST-MODIFIED:").append(iCalendarDateFormat.format(new Date())).append("\n")
                .append("LOCATION:Open Video Room\n")
                .append("ORGANIZER:mailto:").append(idto.getUserEmail()).append("\n")
                .append(customRule)
                .append("SEQUENCE:0\n")
                .append("STATUS:CONFIRMED\n")
                .append("SUMMARY:").append(idto.getCalSubject()).append("\n")
                .append("TRANSP:OPAQUE\n")
                .append("END:VEVENT\n")
                .append("END:VCALENDAR");

        calendarPart.addHeader("Content-Class", "urn:content-classes:calendarmessage");
        //  calendarPart.setContent(calendarContent, "text/calendar;method=CANCEL");
        calendarPart.setContent(icalText.toString(), "text/calendar;method=CANCEL");

        return calendarPart;
    }

    public static String my_time_in(String target_time_zone, String format) {
        TimeZone tz = TimeZone.getTimeZone(target_time_zone.substring(5));
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat date_format_gmt = new SimpleDateFormat(format);
        date_format_gmt.setTimeZone(tz);
        return date_format_gmt.format(date);
    }

}
