package br.com.elton.api.web.bean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.elton.api.service.ClientService;
import br.com.elton.api.service.EmployeeService;

@Component("reportBean")
@Scope("request")
public class ReportBean {
	
	private final DecimalFormat df =  new DecimalFormat();
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private EmployeeService employeeService;
	
    private DonutChartModel donutModel;
    
    @PostConstruct
    public void init() {
    	createDonutModel();
    }

    public void createDonutModel() {
        donutModel = new DonutChartModel();
        ChartData data = new ChartData();
        df.setMaximumFractionDigits(2);
        
        Integer countClient = clientService.countActiveClient();
        Integer countEmployee = employeeService.countActiveEmployee();
        
        Double percentageClient = this.percentageClient(countClient, countEmployee);
        Double percentageEmployee = this.percentageEmployee(countClient, countEmployee);
         
        DonutChartDataSet dataSet = new DonutChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(countClient);
        values.add(countEmployee);
        dataSet.setData(values);
         
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);
         
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Percentage Client: " + df.format(percentageClient) +"%" + " ,quantity: " + countClient);
        labels.add("Percentage Employee: " + df.format(percentageEmployee) +"%" + " ,quantity: " + countEmployee);
        data.setLabels(labels);
         
        donutModel.setData(data);
    }
    
    private Double percentageClient(Integer countClient, Integer countEmployee) {
    	Double percentage = ((100D * countClient) / ((countClient + countEmployee)));
    	return percentage;
    }
    
    private Double percentageEmployee(Integer countClient, Integer countEmployee) {
    	Double percentage = ((100D * countEmployee) / ((countClient + countEmployee)));
    	return percentage;
    }
  
    public DonutChartModel getDonutModel() {
        return donutModel;
    }
 
    public void setDonutModel(DonutChartModel donutModel) {
        this.donutModel = donutModel;
    }
	    
}