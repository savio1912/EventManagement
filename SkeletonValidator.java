import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * 9 * @author TJ
 * 10 *
 * 11 * This class is used to verify if the Code Skeleton is intact and not modified by participants thereby ensuring
 * smooth auto evaluation
 * 12 *
 * 13
 */
public class SkeletonValidator {

    public SkeletonValidator() {

        //classes
        validateClassName("Main");
        validateClassName("EventManagement");
        validateClassName("Participant");
        validateClassName("InvalidEventException");
        //functional methods
        validateMethodSignature(
                "calculateRegistrationFee:void", "EventManagement");
        validateMethodSignature(
                "run:void", "EventManagement");

        //setters and getters of HallHandler
        validateMethodSignature(
                "getTechList:List", "EventManagement");
        validateMethodSignature(
                "setTechList:void", "EventManagement");
        validateMethodSignature(
                "getCounter:int", "EventManagement");
        validateMethodSignature(
                "setCounter:void", "EventManagement");

        validateMethodSignature(
                "getSearchEvent:String", "EventManagement");
        validateMethodSignature(
                "setSearchEvent:void", "EventManagement");

        //setters and getters of Hall
        validateMethodSignature(
                "getName:String", "Participant");
        validateMethodSignature(
                "setName:void", "Participant");

        validateMethodSignature(
                "getYearofstudy:String", "Participant");
        validateMethodSignature(
                "setYearofstudy:void", "Participant");

        validateMethodSignature(
                "getDepartment:String", "Participant");
        validateMethodSignature(
                "setDepartment:void", "Participant");

        validateMethodSignature(
                "getCollegeName:String", "Participant");
        validateMethodSignature(
                "setCollegeName:void", "Participant");

        validateMethodSignature(
                "getEventName:String", "Participant");
        validateMethodSignature(
                "setEventName:void", "Participant");

        validateMethodSignature(
                "getRegistrationFee:double", "Participant");
        validateMethodSignature(
                "setRegistrationFee:void", "Participant");

    }

    private static final Logger LOG = Logger.getLogger("SkeletonValidator");

    protected final boolean validateClassName(String className) {

        boolean iscorrect = false;
        try {
            Class.forName(className);
            iscorrect = true;
            LOG.info("Class Name " + className + " is correct");

        } catch (ClassNotFoundException e) {
            LOG.log(Level.SEVERE, "You have changed either the " + "class name /package.Use the correct package" + "and class name as provided in the skeleton");

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "There is an error in validating the " + "Class Name. Please manually verify that the" + "Class name is same as skeleton before uploading");
        }
        return iscorrect;

    }

    protected final void validateMethodSignature(String methodWithExcptn, String className) {
        Class cls = null;
        try {

            String[] actualmethods = methodWithExcptn.split(",");
            boolean errorFlag = false;
            String[] methodSignature;
            String methodName = null;
            String returnType = null;

            for (String singleMethod : actualmethods) {
                boolean foundMethod = false;
                methodSignature = singleMethod.split(":");

                methodName = methodSignature[0];
                returnType = methodSignature[1];
                cls = Class.forName(className);
                Method[] methods = cls.getMethods();
                for (Method findMethod : methods) {
                    if (methodName.equals(findMethod.getName())) {
                        foundMethod = true;
                        if
                        (!(findMethod.getReturnType().getName().contains(returnType))) {
                            errorFlag = true;
                            LOG.log(Level.SEVERE, " You have changed the" + " return type in '" + methodName + "' method.Please stick to the " + " skeleton provided ");

                        } else {
                            LOG.info("Method signature of "
                                    + methodName + " is valid");
                        }

                    }
                }
                if (!foundMethod) {
                    errorFlag = true;
                    LOG.log(Level.SEVERE, " Unable to find the given public method " + methodName + ". Do not change the " + "given public method name." + " Verify it with the skeleton ");
                }

            }
            if (!errorFlag) {
                LOG.info("Method signature is valid");
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE,
                    " There is an error in validating the " + "method structure. Please manually verify that the " + "Method signature is same as the skeleton before uploading");
        }
    }
}