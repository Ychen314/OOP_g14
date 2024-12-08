public class InsuranceProvider {
    String insuranceCompany;
    int insuranceId;
    String contactInfo;
    String insuranceAgent;

    public InsuranceProvider(String insuranceCompany, int insuranceId, int contactInfo, String insuranceAgent){
        this.insuranceCompany = insuranceCompany;
        this.insuranceId = insuranceId;
        this.contactInfo = contactInfo;
        this.insuranceAgent = insuranceAgent;
    }

    public static void main(String[]args){
        InsuranceProvider provider1 = new InsuranceProvider("AIA Malaysia", 1, "0166391090", "MrTEH");
        InsuranceProvider provider2 = new InsuranceProvider("Great Eastern Life Assurance", 2, "0166391090", "Mr CHEN";);
        InsuranceProvider provider3 = new InsuranceProvider("Tokio Marine Insurance (Malaysia) Berhad", 3, "0166391090", "Mr Ming");
        InsuranceProvider provider4 = new InsuranceProvider("Takaful Malaysia", 4, "0166391090", "Mr James");
        InsuranceProvider provider5 = new InsuranceProvider("Prudential Assurance Malaysia Berhad (PAMB)", 5, "0166391090", "Mr Alfred");
        InsuranceProvider provider6 = new InsuranceProvider("Manulife Insurance Berhad", 6, "0166391090", "Mr Bryan");
        
    }
}
