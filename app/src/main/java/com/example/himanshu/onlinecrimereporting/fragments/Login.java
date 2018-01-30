package com.example.himanshu.onlinecrimereporting.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.himanshu.onlinecrimereporting.R;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    FragmentTransaction fragmentTransaction = null;
    public String username=null,password=null;
    public static final String UrlLogin = "http://thetechnophile.000webhostapp.com/login_bookdeals.php";
    public static final String KEY_USERNAME = "email";
    public static final String KEY_PASSWORD = "pwd";
    ProgressDialog pd;
    public static final String url = "http://thetechnophile.000webhostapp.com/signup_bookdeals.php";
    EditText uuname, passwd, signuname, signpasswd, signemail;
    Button login, signup;
    public static String uname, uemail, upass, urepass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        login = (Button) v.findViewById(R.id.buttonLogin);
        signup = (Button) v.findViewById(R.id.buttonSignup);

        uuname = (EditText) v.findViewById(R.id.enterusername);
        passwd = (EditText) v.findViewById(R.id.enterpasswd);
        signuname = (EditText) v.findViewById(R.id.signupusername);
        signemail = (EditText) v.findViewById(R.id.signupemail);
        signpasswd = (EditText) v.findViewById(R.id.signupepasswd);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupUser();
            }
        });

        return v;
    }

    public void signupUser() {

        uname = signuname.getText().toString().trim();
        uemail = signemail.getText().toString().trim();
        upass = signpasswd.getText().toString().trim();
        urepass = signpasswd.getText().toString().trim();

        if (uemail.equals("") || !android.util.Patterns.EMAIL_ADDRESS.matcher(uemail).matches()) {
            signemail.setError("Invalid Email Address/Please Enter Email");
        }
        if (uname.equals("")) {
            signuname.setError("Invalid or Empty Fields");
        }

        if (upass.isEmpty() || upass.length() < 4 || upass.length() > 15) {
            signpasswd.setError("Password At Least 4-10 Characters");

        } else {
            pd = new ProgressDialog(getActivity());
            pd.setCancelable(false);
            pd.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
            pd.show();
            signUpUserInIt();
            pd.dismiss();

        }

    }

    public void signUpUserInIt() {


        StringRequest st = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_mainn, new Report_Crime());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(), "Unable to Sign Up", Toast.LENGTH_LONG).show();
            }

        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put("user_nm", uname);
                parameters.put("email", uemail);
                parameters.put("pwd", upass);
                parameters.put("re_pwd", urepass);
                return parameters;

            }

        };


        RequestQueue rq = Volley.newRequestQueue(getActivity());
        rq.add(st);
    }


    public void loginUser() {

        pd = new ProgressDialog(getActivity());
        pd.setCancelable(false);
        pd.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        pd.show();
        userLoginInIt();
        pd.dismiss();

    }

    public void userLoginInIt() {

        username=uuname.getText().toString().trim();
        password=passwd.getText().toString().trim();



        StringRequest st=new StringRequest(Request.Method.POST, UrlLogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("Successful Login")) {

                }
                else {
                    Toast.makeText(getActivity(),"Login Successful",Toast.LENGTH_SHORT).show();

                    fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_mainn, new Report_Crime());
                    fragmentTransaction.commit();
                    fragmentTransaction.addToBackStack(null);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                passwd.setError("Wrong Username/Passsword");
            }

        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put(KEY_USERNAME,username);
                parameters.put(KEY_PASSWORD,password);

                return parameters;

            }

        };
        RequestQueue rq= Volley.newRequestQueue(getActivity());
        rq.add(st);
    }

}
