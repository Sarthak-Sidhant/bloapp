package in.gov.eci.bloapp.views.activity.sir;

import in.gov.eci.bloapp.api.RestClient;
import in.gov.eci.bloapp.api.service.UserClient;
import java.lang.reflect.Method;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class ApiInspector {
    public static void printAllApis() {
        for (Method method : UserClient.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(GET.class)) {
                System.out.println("GET " + method.getAnnotation(GET.class).value() + " -> " + method.getName());
            } else if (method.isAnnotationPresent(POST.class)) {
                System.out.println("POST " + method.getAnnotation(POST.class).value() + " -> " + method.getName());
            } else if (method.isAnnotationPresent(PUT.class)) {
                System.out.println("PUT " + method.getAnnotation(PUT.class).value() + " -> " + method.getName());
            } else if (method.isAnnotationPresent(DELETE.class)) {
                System.out.println("DELETE " + method.getAnnotation(DELETE.class).value() + " -> " + method.getName());
            }
        }
        for (Method method2 : RestClient.class.getDeclaredMethods()) {
            if (method2.isAnnotationPresent(GET.class)) {
                System.out.println("GET " + method2.getAnnotation(GET.class).value() + " -> " + method2.getName());
            } else if (method2.isAnnotationPresent(POST.class)) {
                System.out.println("POST " + method2.getAnnotation(POST.class).value() + " -> " + method2.getName());
            } else if (method2.isAnnotationPresent(PUT.class)) {
                System.out.println("PUT " + method2.getAnnotation(PUT.class).value() + " -> " + method2.getName());
            } else if (method2.isAnnotationPresent(DELETE.class)) {
                System.out.println("DELETE " + method2.getAnnotation(DELETE.class).value() + " -> " + method2.getName());
            }
        }
    }
}
