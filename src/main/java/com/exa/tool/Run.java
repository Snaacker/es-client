package com.exa.tool;
import com.exa.tool.types.JSonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.Properties;

public class Run {
    static TransportClient client;
    TransportAddress address;
    public static void main(String args[]){
        Run run = new Run();
        String filePath = run.readKey("FilePath");
        String elasticURI = run.readKey("ElasticURI");
        String elasticUser = run.readKey("ElasticUser");
        String elasticPass = run.readKey("ElasticPass");
        String elasticCluster = run.readKey("ElasticCluster");
        String elasticNode = run.readKey("ElasticNode");
        String index = run.readKey("Index");
        String indexType = run.readKey("Type");
        System.out.println("======================================================");
        System.out.println("filePath: " + filePath);
        System.out.println("elasticUrI: " + elasticURI);
        System.out.println("elasticUser: " + elasticUser);
        System.out.println("elasticNode: " + elasticNode);
        System.out.println("elasticCluster: " + elasticCluster);
        System.out.println("elasticUrl: " + elasticURI);
        System.out.println("index: " + index);
        System.out.println("indexType: " + indexType);
        System.out.println("======================================================");
        try {
            client = new PreBuiltTransportClient(
                    Settings.builder()
                            .put("cluster.name", elasticCluster)
                            .put("node.name", elasticNode)
                            .build())
                .addTransportAddress(new TransportAddress(InetAddress.getByName(elasticURI), 9300));

            IndicesExistsRequest request = new IndicesExistsRequest(index);
            IndicesExistsResponse response = client.admin().indices().exists(request).actionGet();
            if (response.isExists()) {
                System.out.println(new Date() + " - Index is existed, we'll delete it to re-import index");
                DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index);
                try {
                    DeleteIndexResponse deleteIndexResponse = client.admin().indices().delete(deleteIndexRequest).actionGet();
                    if (!deleteIndexResponse.isAcknowledged()) {
                        throw new Exception("Failed to delete index " + index);
                    }
                    System.out.println(new Date() + " - Done delete index");
                } catch (Exception e) {
                    System.out.println(new Date() + " - Can not delete index");
                    e.printStackTrace();
                }
            }
            System.out.println(new Date() + " - Start create new index");
            CreateIndexResponse createIndexResponse = client.admin().indices().prepareCreate(index).get();
            System.out.println(new Date() + " - Start import record to Elasticsearch server");
            InsertDocument(filePath, index, indexType);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void InsertDocument(String filePath, String index, String indexType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JSonData[] jsonData = mapper.readValue(new File(filePath), JSonData[].class);
        for ( JSonData data : jsonData){

            IndexResponse response = client.prepareIndex(
                    index,
                    indexType,
                    data.getId().getOid()).setSource().get();
        }
    }

    public String readKey(String key){
        String propertiesFilename = "config.properties";
        ClassLoader objClassLoader = getClass().getClassLoader();
        Properties configProperties = new Properties();
        try(
                FileInputStream objFileInputStream = new FileInputStream(objClassLoader.getResource(propertiesFilename).getFile());
        ){
            configProperties.load(objFileInputStream);
            return String.valueOf(configProperties.get(key));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
