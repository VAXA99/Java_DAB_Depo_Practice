import React from 'react';
import styles from './WagonList.css'
import Header from "../Header/Header";

const WagonList = ({wagons}) => {
    return (
        <>
            <Header/>
            <table className="wagons-table">
                <thead>
                <tr>
                    <th className="table-header">ID</th>
                    <th className="table-header">Тип</th>
                    <th className="table-header">Процент загрузки</th>
                    <th className="table-header">Серийный номер</th>
                    <th className="table-header">Станция приписки</th>
                    <th className="table-header">Грузопододъемность</th>
                    <th className="table-header">Год выпуска</th>
                    <th className="table-header">Исправность</th>
                </tr>
                </thead>
                <tbody>
                {wagons.map((wagon) => (
                    <tr key={wagon.id} className="wagon-row">
                        <td className="table-data">{wagon.id}</td>
                        <td className="table-data">{wagon.wagonType}</td>
                        <td className="table-data">{wagon.loadingPercentage}</td>
                        <td className="table-data">{wagon.serialNumber}</td>
                        <td className="table-data">{wagon.homeStation}</td>
                        <td className="table-data">{wagon.loadCapacity}</td>
                        <td className="table-data">{wagon.yearOfRelease}</td>
                        <td className="table-data">{wagon.isServicable}</td>
                        <td className="table-change">
                            <a href={`/wagons/changeStatus/${wagon.id}`} className="edit-btn">🔄</a>
                            <a href={`/edit/${wagon.id}`} className="edit-btn">✏️</a>
                            <a href={`/delete/${wagon.id}`} className="delete-btn">❌</a>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </>
    );
}

export default WagonList;
