package com.hakkinenT.cinemamongo.models.entities.sessions.compositeKey;

public class SessionPK {
    private String exhibitionDate;
    private Integer roomNumber;

    public SessionPK() {
    }

    public SessionPK(String exhibitionDate, Integer roomNumber) {
        this.exhibitionDate = exhibitionDate;
        this.roomNumber = roomNumber;
    }

    public String getExhibitionDate() {
        return exhibitionDate;
    }

    public void setExhibitionDate(String exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((exhibitionDate == null) ? 0 : exhibitionDate.hashCode());
        result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SessionPK other = (SessionPK) obj;
        if (exhibitionDate == null) {
            if (other.exhibitionDate != null)
                return false;
        } else if (!exhibitionDate.equals(other.exhibitionDate))
            return false;
        if (roomNumber == null) {
            if (other.roomNumber != null)
                return false;
        } else if (!roomNumber.equals(other.roomNumber))
            return false;
        return true;
    }

    
    
}
