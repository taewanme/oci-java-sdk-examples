package kim.taewan.oci;

import com.oracle.bmc.auth.AuthenticationDetailsProvider;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorage;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.GetNamespaceRequest;
import com.oracle.bmc.objectstorage.responses.GetNamespaceResponse;
import com.oracle.bmc.Region;

/**
 * Hello world!
 *
 */
public class BasicConfigTest 
{
    public static void main( String[] args ) throws Exception 
    {
        String configurationFilePath = "~/.oci/config";
        String profile = "DEFAULT";

        AuthenticationDetailsProvider provider =
                new ConfigFileAuthenticationDetailsProvider(configurationFilePath, profile);
        
        ObjectStorage client = new ObjectStorageClient(provider);
        client.setRegion(Region.US_ASHBURN_1);

        GetNamespaceResponse namespaceResponse = client.getNamespace(GetNamespaceRequest.builder().build());
        System.out.println("============================");
        System.out.println("Tenancy:"+namespaceResponse.getValue());
        System.out.println("============================");
    }
}
