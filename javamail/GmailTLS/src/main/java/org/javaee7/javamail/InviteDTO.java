package org.javaee7.javamail;
import java.util.Date;
/**
 *
 * @author Masud
 */
public class InviteDTO {
    
    private String subject;
    private String calSubject;
    private String mailTo[];
    private Date from;
    private Date to;
    private String mailText;
    private boolean isRecurrance;
    private String repeatType;
    
    private String dayType;
    private Integer daysRepeat;

    
    private Integer weeklyRepeat;
    private String weekDays[];

    
    private Integer monthlyRepeat;
    private String monthOnType;
    private Integer monthOnDay;
    private String monthOnWeekDayType;
    private String monthOnWeekDay;    
    
    private String endType;
    private Integer endOcur;
    private Date endOnDate;
    
    private String hostCode;
    private String customerName;
    
    private String timeZone;
    private String startTime;
    private String endTime;
    private String userEmail;
    private String filename;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCalSubject() {
        return calSubject;
    }

    public void setCalSubject(String calSubject) {
        this.calSubject = calSubject;
    }

    public String[] getMailTo() {
        return mailTo;
    }

    public void setMailTo(String[] mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailText() {
        return mailText;
    }

    public void setMailText(String mailText) {
        this.mailText = mailText;
    }
   
    
    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public boolean isIsRecurrance() {
        return isRecurrance;
    }

    public void setIsRecurrance(boolean isRecurrance) {
        this.isRecurrance = isRecurrance;
    }

    public String getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(String repeatType) {
        this.repeatType = repeatType;
    }

    public String getDayType() {
        return dayType;
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
    }

  

    public Integer getDaysRepeat() {
        return daysRepeat;
    }

    public void setDaysRepeat(Integer daysRepeat) {
        this.daysRepeat = daysRepeat;
    }

    public Integer getWeeklyRepeat() {
        return weeklyRepeat;
    }

    public void setWeeklyRepeat(Integer weeklyRepeat) {
        this.weeklyRepeat = weeklyRepeat;
    }

    public String[] getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(String[] weekDays) {
        this.weekDays = weekDays;
    }

    public Integer getMonthlyRepeat() {
        return monthlyRepeat;
    }

    public void setMonthlyRepeat(Integer monthlyRepeat) {
        this.monthlyRepeat = monthlyRepeat;
    }

    public String getMonthOnType() {
        return monthOnType;
    }

    public void setMonthOnType(String monthOnType) {
        this.monthOnType = monthOnType;
    }

    public Integer getMonthOnDay() {
        return monthOnDay;
    }

    public void setMonthOnDay(Integer monthOnDay) {
        this.monthOnDay = monthOnDay;
    }

    public String getMonthOnWeekDayType() {
        return monthOnWeekDayType;
    }

    public void setMonthOnWeekDayType(String monthOnWeekDayType) {
        this.monthOnWeekDayType = monthOnWeekDayType;
    }

    public String getMonthOnWeekDay() {
        return monthOnWeekDay;
    }

    public void setMonthOnWeekDay(String monthOnWeekDay) {
        this.monthOnWeekDay = monthOnWeekDay;
    }

    public String getEndType() {
        return endType;
    }

    public void setEndType(String endType) {
        this.endType = endType;
    }

    public Integer getEndOcur() {
        return endOcur;
    }

    public void setEndOcur(Integer endOcur) {
        this.endOcur = endOcur;
    }

    public Date getEndOnDate() {
        return endOnDate;
    }

    public void setEndOnDate(Date endOnDate) {
        this.endOnDate = endOnDate;
    }

    public String getHostCode() {
        return hostCode;
    }

    public void setHostCode(String hostCode) {
        this.hostCode = hostCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }  

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    
}
