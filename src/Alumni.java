
public class Alumni implements CommonMethods {
    private int id;
    private String name;
    private String address;
    private String major;
    private String gradYear;
    private String job;
    private String organization;
    private String password;
    // private boolean admin = false;

    public Alumni() {

    }

    /**
     * passing in values for alumni
     * @param name name of alumni
     * @param address mailing address
     * @param major School Major for alumni's degree
     * @param gradYear Year of graduation 
     * @param job employment of alumni
     * @param organization employer of alumni
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

    // password-less constructor for host
    public Alumni(int id, String name, String address, String major, String gradYear, String job, String organization) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.major = major;
        this.gradYear = gradYear;
        this.job = job;
        this.organization = organization;
    }


    public int getID() {
        return id;
    }
    /**
     * to get the name of alumni
     * @return returns the name of alumni 
     */ 
    public String getName() {
        return this.name;
    }

    /**
     * sets name of alumni
     * @param name passing name of alumni
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get address of alumni
     * @return the address of alumni
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * sets address of alumni
     * @param address passing address of alumni
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * gets major of alumni
     * @return the major if alumni
     */
    public String getMajor() {
        return this.major;
    }

    /**
     * sets major of alumni
     * @param major passing major of alumni
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * gets year of graduation of alumni
     * @return year of graduation of alumni
     */
    public String getGradYear() {
        return this.gradYear;
    }

    /**
     * sets graduation year of graduation alumni
     * @param gradYear passing year of graduation for alumni
     */
    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    /**
     * get job of alumni
     * @return job of alumni
     */
    public String getJob() {
        return this.job;
    }

    /**
     * sets job of alumni
     * @param job passing value of alumni's job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * gets organization of alumni
     * @return organization of alumni
     */
    public String getOrganization() {
        return this.organization;
    }

    /**
     * sets organization of alumni
     * @param organization passing the value of the alumni's organization
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
    * Gets the Alumni's Password
    * @return Alumni's password
    */
    public String getPassword(){
        return password;
    }

    /**
    * sets a new password for the alumni
    * @param password new password that is a String   
    */
    public void setPassword(String password){
        this.password = password;
    }
    

    @Override
    // TODO MAKE HUMAN READABLE 
    public String toString() {
        return "{" +
            " id='" + getID() + "'" +
            ", name='" + getName() + "'" +
            ", address='" + getAddress() + "'" +
            ", major='" + getMajor() + "'" +
            ", gradYear='" + getGradYear() + "'" +
            ", job='" + getJob() + "'" +
            ", organization='" + getOrganization() + "'" +
            "}";
    }

    public String save() {
        return getID() + "," + getName() + "," + getAddress() + "," + getMajor() + "," + getGradYear() + "," + getJob() + "," + getOrganization();
    }
}
