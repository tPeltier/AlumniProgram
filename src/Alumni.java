
public class Alumni implements CommonMethods {
    private int id;
    private String name;
    private String address;
    private String major;
    private String gradYear;
    private String job;
    private String organization;
    private String password;
    

    /**
     * Empty Alumni Constructor
     */
    public Alumni() {

    }

    /**
     * Constructor for the creation of Alumni 
     * @param id ID of the Alumni
     * @param name Name of the Alumni
     * @param address Mailing address of Alumni
     * @param major Graduating major of Alumni
     * @param gradYear Year of graduation
     * @param job Job title of ALumni
     * @param organization Alumni's Employer's name 
     * @param password Alumni's password
     */
    public Alumni(int id, String name, String address, String major, String gradYear, String job, String organization, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.major = major;
        this.gradYear = gradYear;
        this.job = job;
        this.organization = organization;
        this.password = password;
    }

    /**
     * Password-less Alumni constructor for the creation of a Host object
     * @param id ID of the Alumni
     * @param name Name of the Alumni
     * @param address Mailing address of Alumni
     * @param major Graduating major of Alumni
     * @param gradYear Year of graduation
     * @param job Job title of ALumni
     * @param organization Alumni's Employer's name 
     */
    public Alumni(int id, String name, String address, String major, String gradYear, String job, String organization) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.major = major;
        this.gradYear = gradYear;
        this.job = job;
        this.organization = organization;
    }


    // ==================== GETTERS ====================

    /**
     * Get mailing address of Alumni
     * @return Mailing address of Alumni
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Get the year of graduation of Alumni
     * @return Graduation year of ALumni
     */
    public String getGradYear() {
        return this.gradYear;
    }

    /**
     * Get the ALumni's ID
     * @return Alumni's ID
     */
    public int getID() {
        return id;
    }

    /**
     * Get the job title of alumni
     * @return Alumni's job title
     */
    public String getJob() {
        return this.job;
    }

    /**
     * Get the graduating major of Alumni
     * @return Alumni's graduating major
     */
    public String getMajor() {
        return this.major;
    }

    /**
     * Get the Alumni's name
     * @return Alumni's name
     */ 
    public String getName() {
        return this.name;
    }

    /**
     * Get the organization of Alumni
     * @return Organization of alumni
     */
    public String getOrganization() {
        return this.organization;
    }

    /**
    * Get the Alumni's Password
    * @return Alumni's password
    */
    public String getPassword(){
        return password;
    }

    // ==================== SETTERS ====================

    /**
     * Set the mailing address of Alumni
     * @param address Mailing address to set for Alumni
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set the graduation year of Alumni
     * @param gradYear Graduation year to set for ALumni
     */
    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    /**
     * Set the job title of Alumni
     * @param job Job title to set for Alumni
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * Set the graduating major of alumni
     * @param major Graduating major to set for Alumni
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Set the name of Alumni
     * @param name Name to set as Alumni's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the organization of alumni
     * @param organization Organization to set for ALumni
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
    * Set a new password for the alumni
    * @param password Password to set for Alumni
    */
    public void setPassword(String password){
        this.password = password;
    }
    

    // ==================== RAND ====================

    @Override
    public String toString() {
        return "Alumni ID: " + getID() + " |" + " Alumni Name: " + getName() + " |" + " Alumni Address: " + getAddress() + " |" + " Alumni Major: " + getMajor() + " |" + " Alumni Graduation Year: " + getGradYear() + " |" + " Alumni Job Title: " + getJob() + " |" + " Alumni's Employing Organization: " + getOrganization();
    }

    /**
     * Save the Alumni's information
     * @return ALumni's information formatted to save to text file
     */
    public String save() {
        return getID() + "," + getName() + "," + getAddress() + "," + getMajor() + "," + getGradYear() + "," + getJob() + "," + getOrganization();
    }
}
