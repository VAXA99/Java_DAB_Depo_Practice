import React from 'react';
import styles from './EditWagonForm.css';
import Header from '../Header/Header';
import {backend} from "../../backend";

const EditWagonForm = ({ wagon }) => {
    const handleSubmit = async (event) => {
        event.preventDefault();
        const form = event.target;
        const formData = new FormData(form);

        try {
            await backend.updateWagon(wagon.id, formData);
            // Handle success, e.g., show a success message or redirect
        } catch (error) {
            // Handle error, e.g., display an error message
            console.error('Error updating wagon:', error);
        }
    };

    return (
        <>
            <Header />
            <form onSubmit={handleSubmit}>
                <table className="wagons-table">
                    <thead>
                    <tr>
                        <th className="table-header">Тип</th>
                        <th className="table-header">Процент загрузки</th>
                        <th className="table-header">Серийный номер</th>
                        <th className="table-header">Станция приписки</th>
                        <th className="table-header">Грузоподъемность</th>
                        <th className="table-header">Год выпуска</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td className="table-data">
                            <input defaultValue={wagon.wagonType} type="text" name="wagonType"/>
                        </td>
                        <td className="table-data">
                            <input defaultValue={wagon.loadingPercentage} type="text" name="loadingPercentage"/>
                        </td>
                        <td className="table-data">
                            <input defaultValue={wagon.serialNumber} type="number" name="serialNumber"/>
                        </td>
                        <td className="table-data">
                            <input defaultValue={wagon.homeStation} type="text" name="homeStation"/>
                        </td>
                        <td className="table-data">
                            <input defaultValue={wagon.loadCapacity} type="number" name="loadCapacity"/>
                        </td>
                        <td className="table-data">
                            <input defaultValue={wagon.yearOfRelease} type="number" name="yearOfRelease"/>
                        </td>
                        <td className="table-change">
                            <button type="submit">✅</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </>
    );
};

export default EditWagonForm;









