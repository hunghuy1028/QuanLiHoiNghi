package POJOs;
// Generated 15-Jul-2020 14:10:35 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserHoinghiId generated by hbm2java
 */
@Embeddable
public class UserHoinghiId  implements java.io.Serializable {


     private int idHoiNghi;
     private int idUser;

    public UserHoinghiId() {
    }

    public UserHoinghiId(int idHoiNghi, int idUser) {
       this.idHoiNghi = idHoiNghi;
       this.idUser = idUser;
    }
   


    @Column(name="idHoiNghi", nullable=false)
    public int getIdHoiNghi() {
        return this.idHoiNghi;
    }
    
    public void setIdHoiNghi(int idHoiNghi) {
        this.idHoiNghi = idHoiNghi;
    }


    @Column(name="idUser", nullable=false)
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserHoinghiId) ) return false;
		 UserHoinghiId castOther = ( UserHoinghiId ) other; 
         
		 return (this.getIdHoiNghi()==castOther.getIdHoiNghi())
 && (this.getIdUser()==castOther.getIdUser());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdHoiNghi();
         result = 37 * result + this.getIdUser();
         return result;
   }   


}

