package helpers;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.*;
import models.CloudFile;
import models.Post;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * Created by neo on 10/15/15.
 */

public class CloudHelper {

    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=http;"
                    + "AccountName=classroomstorage;"
                    + "AccountKey=330dBXLxq5BSfk5ndwejrLaArf2Ml/OUDy1zrzfcNkXxpyGdGRy0mciK3oQ3D/Gwtv8KFcx5ZEXoS/g+W0hkEw==;";



    public static void createContainer(){
        try
        {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Get a reference to a container.
            // The container name must be lower case
            CloudBlobContainer container = blobClient.getContainerReference("classroomcontainer");

            // Create the container if it does not exist.
            container.createIfNotExists();

            // Create a permissions object.
            BlobContainerPermissions containerPermissions = new BlobContainerPermissions();

            // Include public access in the permissions object.
            containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);

            // Set the permissions on the container.
            container.uploadPermissions(containerPermissions);
        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }
    }



    public static void uploadToCloud(File file,String fileName, Long id){
        try
        {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Retrieve reference to a previously created container.
            CloudBlobContainer container = blobClient.getContainerReference("classroomcontainer");


            // Create or overwrite the "myimage.jpg" blob with contents from a local file.
//            CloudBlockBlob blob = container.getBlockBlobReference(fileName);


            File source = file;
            CloudBlockBlob blob = container.getBlockBlobReference(fileName);
            Post post = Post.findPostById(id);
            new CloudFile(fileName,post);
            blob.upload(new FileInputStream(source), source.length());
        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }

    }

    public static void downloadFromCloud(){
        try
        {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Retrieve reference to a previously created container.
            CloudBlobContainer container = blobClient.getContainerReference("classroomcontainer");

            // Loop through each blob item in the container.
            for (ListBlobItem blobItem : container.listBlobs()) {
                // If the item is a blob, not a virtual directory.
                if (blobItem instanceof CloudBlob) {
                    // Download the item and save it to a file with the same name.
                    CloudBlob blob = (CloudBlob) blobItem;
                    blob.download(new FileOutputStream(blob.getName()));
                }
            }
        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }
    }
}

