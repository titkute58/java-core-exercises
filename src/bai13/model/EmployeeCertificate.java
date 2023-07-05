package bai13.model;

import java.time.LocalDate;

public class EmployeeCertificate {
    private String CertificatedID;
    private String CertificateName;
    private int CertificateRank;
    private String CertificatedDate;

    public EmployeeCertificate(String certificatedID, String certificateName, int certificateRank, String certificatedDate) {
        CertificatedID = certificatedID;
        CertificateName = certificateName;
        CertificateRank = certificateRank;
        CertificatedDate = certificatedDate;
    }

    public String getCertificatedID() {
        return CertificatedID;
    }

    public void setCertificatedID(String certificatedID) {
        CertificatedID = certificatedID;
    }

    public String getCertificateName() {
        return CertificateName;
    }

    public void setCertificateName(String certificateName) {
        CertificateName = certificateName;
    }

    public int getCertificateRank() {
        return CertificateRank;
    }

    public void setCertificateRank(int certificateRank) {
        CertificateRank = certificateRank;
    }

    public String getCertificatedDate() {
        return CertificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        CertificatedDate = certificatedDate;
    }
}
