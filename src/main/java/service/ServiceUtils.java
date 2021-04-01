package service;

public class ServiceUtils {

    public static long[] fromStringArrayInIntArray(String parameterValues) {
        String tempDeleteSpace = parameterValues.replaceAll(" ", "");
        String[] tempIdActors = tempDeleteSpace.split(",");
        //todo нужно вот этот костыль поправить

        long[] idEntity = new long[tempIdActors.length];
        for (int i = 0; i < tempIdActors.length; i++) {
            idEntity[i] = Long.parseLong(tempIdActors[i]);
        }

        return idEntity;
    }

    public static Service commandDefinition(String command, String defaultCommand) throws Exception {
        return command != null ? FactoryService.valueOf(command).getService() : FactoryService.valueOf(defaultCommand).getService();
    }
}
