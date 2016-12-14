package helpers;

import java.util.ResourceBundle;

public class PropertyProvider {

   private static String CONFIG_PATH = "config";
    private static ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_PATH);

    public static String getProperty(String propertyName) {
        return bundle.getString(propertyName);
    }
}


     /*    EXAMPLE WITH PROPERTY FOR MYSELF


    private static PropertyProvider instance = null;
        private static Properties properties = new Properties();
        private static String propPath = "src\\main\\resources\\config.properties";

        private PropertyProvider() {
            propPath = FilenameUtils.separatorsToSystem(new File("").getAbsolutePath() + "\\" + propPath);
            loadProperties(propPath);
        }

        private void loadProperties(String fileName) {
            File localFile = new File(fileName);
            if (!localFile.isDirectory()) {
                try {
                    FileInputStream fis = new FileInputStream(localFile.getAbsolutePath());
                    properties.load(fis);
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Exception's happened trying to load props from: " + fileName);
                }
            }
        }

        public static String getProperty(String propertyName) {
            if(instance == null) instance = new PropertyProvider();

            String propertyValue;
            if ((System.getProperty(propertyName) != null)) {
                propertyValue = System.getProperty(propertyName);
            } else
                propertyValue = PropertyProvider.properties.getProperty(propertyName);
            return propertyValue;
        }
}*/





