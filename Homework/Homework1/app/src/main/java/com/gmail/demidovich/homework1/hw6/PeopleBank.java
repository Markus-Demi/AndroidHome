package com.gmail.demidovich.homework1.hw6;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

//import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class PeopleBank {
    private String name;

    @SerializedName("date")
    private Date mDate;

    @SerializedName("gender")
    private Gender mGender;

    @SerializedName("people")
    private List<People> mPeopleList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Gender getGender() {
        return mGender;
    }

    public void setGender(Gender gender) {
        mGender = gender;
    }

    public List<People> getPeopleList() {
        return mPeopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        mPeopleList.addAll(peopleList);
    }

    public void wordSearch(String word) {
        for (People people : mPeopleList) {

//            if(people.getName().contains(word)) {
//                people.getName();
//            } else {
//                return;
//            }
//            if (checkWordInText(people.getName(), word) || checkWordInText(people.getSurname(), word)) {
//                people.setVisible(true);
//            } else {
//                people.setVisible(false);
//            }
        }
    }

//    private boolean checkWordInText(String text, String word) {
//        if (text != null) {
//            Pattern p = Pattern.compile(".*" + word + ".*", CASE_INSENSITIVE);
//            Matcher m = p.matcher(text);
//            return m.matches();
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeopleBank that = (PeopleBank) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (mDate != null ? !mDate.equals(that.mDate) : that.mDate != null) return false;
        if (mGender != that.mGender) return false;
        return mPeopleList.equals(that.mPeopleList);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (mDate != null ? mDate.hashCode() : 0);
        result = 31 * result + (mGender != null ? mGender.hashCode() : 0);
        result = 31 * result + mPeopleList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PeopleBank{" +
                "name='" + name + '\'' +
                ", mDate=" + mDate +
                ", mGender=" + mGender +
                ", mPeopleList=" + mPeopleList +
                '}';
    }
}
