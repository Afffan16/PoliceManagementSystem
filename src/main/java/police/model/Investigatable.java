/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package police.model;

/**
 *
 * @author HP
 */


import java.util.List;

public interface Investigatable 
{
    void addEvidence(String path);
    void updateStatus(String status);
    String getCaseSummary();
    List<String> getEvidencePaths();
    String getCurrentStatus();
}