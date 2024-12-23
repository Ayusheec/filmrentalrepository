import React, { useState } from "react";
import { Link } from "react-router-dom";
import { getCumulativeRevenueByDate, getRevenueByStore, getFilmwiseRevenue, getCumulativeRevenueByStore } from "../service/PaymentService";

const ApiSelector = () => {
    const [selectedApi, setSelectedApi] = useState("");
    const [response, setResponse] = useState(null);
    const [error, setError] = useState(null);

    // List of API options
    const apiOptions = [
        { label: "Get Cumulative Revenue By Date", value: "getCumulativeRevenueByDate" },
        { label: "Get Revenue By Store", value: "getRevenueByStore" },
        { label: "Get Filmwise Revenue", value: "getFilmwiseRevenue" },
        { label: "Get Cumulative Revenue By Store", value: "getCumulativeRevenueByStore" },
    ];

    // Handle API execution
    const executeApi = async () => {
        try {
            setError(null); // Reset error
            let apiResponse;

            switch (selectedApi) {
                case "getCumulativeRevenueByDate":
                    apiResponse = await getCumulativeRevenueByDate();
                    break;
                case "getRevenueByStore":
                    apiResponse = await getRevenueByStore(1); // Example store ID
                    break;
                case "getFilmwiseRevenue":
                    apiResponse = await getFilmwiseRevenue();
                    break;
                case "getCumulativeRevenueByStore":
                    apiResponse = await getCumulativeRevenueByStore(1); // Example store ID
                    break;
                default:
                    setError("Please select a valid API.");
                    return;
            }

            setResponse(apiResponse);
        } catch (err) {
            console.error("Error executing API:", err);
            setError(err.message || "An error occurred.");
        }
    };

    // Render a table for the API response with improved styles
    const renderTable = (data) => {
        if (!data || !Array.isArray(data) || data.length === 0) {
            return <div>No data available.</div>;
        }

        const keys = Object.keys(data[0]); // Get column headers from the first object

        return (
            <table style={{ width: "100%", borderCollapse: "collapse", marginTop: "20px" }}>
                <thead>
                    <tr>
                        {keys.map((key) => (
                            <th key={key} style={{ padding: "10px", border: "1px solid #ddd", textAlign: "center", backgroundColor: "#f4f4f4" }}>
                                {key}
                            </th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    {data.map((item, index) => (
                        <tr key={index}>
                            {keys.map((key) => {
                                let cellValue = item[key];
                                if (cellValue === 0) {
                                    cellValue = "Inactive";
                                } else if (cellValue === 1) {
                                    cellValue = "Active";
                                }

                                return (
                                    <td key={key} style={{ padding: "10px", border: "1px solid #ddd", textAlign: "center" }}>
                                        {cellValue}
                                    </td>
                                );
                            })}
                        </tr>
                    ))}
                </tbody>
            </table>
        );
    };

    return (
        <div style={{ maxWidth: "1200px", margin: "0 auto", padding: "20px" }}>
            <h1 style={{ textAlign: "center", fontSize: "2rem", marginBottom: "20px" }}>Payment Details</h1>

            <div style={{ border: "1px solid #ddd", padding: "20px", borderRadius: "8px", boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)" }}>
                <h4>Select API to Execute</h4>
                <div style={{ marginBottom: "15px" }}>
                    <select
                        value={selectedApi}
                        onChange={(e) => setSelectedApi(e.target.value)}
                        style={{ padding: "10px", width: "100%", fontSize: "1rem", border: "1px solid #ddd", borderRadius: "4px" }}
                    >
                        <option value="">Select an API</option>
                        {apiOptions.map((option) => (
                            <option key={option.value} value={option.value}>
                                {option.label}
                            </option>
                        ))}
                    </select>
                </div>

                <button
                    onClick={executeApi}
                    disabled={!selectedApi}
                    style={{
                        backgroundColor: "#007bff",
                        color: "white",
                        padding: "10px 20px",
                        fontSize: "1rem",
                        border: "none",
                        borderRadius: "4px",
                        cursor: "pointer",
                        width: "100%",
                        marginBottom: "20px",
                    }}
                >
                    Execute API
                </button>

                {error && (
                    <div style={{ padding: "10px", backgroundColor: "#f8d7da", color: "#721c24", marginBottom: "20px", borderRadius: "4px" }}>
                        <strong>Error:</strong> {error}
                    </div>
                )}

                {response && (
                    <div>
                        <h5>API Response:</h5>
                        {renderTable(response)}
                    </div>
                )}

                <div style={{ marginTop: "20px", textAlign: "center" }}>
                    <Link to="/Dashboard" style={{ color: "#007bff", textDecoration: "none" }}>
                        Go to Dashboard
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default ApiSelector;
